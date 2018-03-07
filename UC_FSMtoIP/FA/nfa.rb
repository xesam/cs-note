require './fa_rule'
require 'set'

class NFARulebook < Struct.new(:rules)
  def next_states(states, character)
    states.flat_map { |state|
      follow_rules_for(state, character)
    }.to_set
  end

  def follow_rules_for(state, character)
    rules_for(state, character).map(&:follow)
  end

  def rules_for(state, character)
    rules.select { |rule| rule.applies_to?(state, character) }
  end
end

class NFA < Struct.new(:current_states, :accept_states, :rulebook)
  def accepting?
    (current_states & accept_states).any?
  end

  def read_character(character)
    self.current_states = rulebook.next_states(self.current_states, character)
  end

  def read_string(string)
    string.chars.each { |character|
      read_character(character)
    }
  end
end

class NFADesign < Struct.new(:current_states, :accept_states, :rulebook)
  def to_nfa
    NFA.new(Set[current_states], accept_states, rulebook)
  end

  def accepting?(string)
    to_nfa.tap { |dfa|
      dfa.read_string(string)
    }.accepting?
  end
end


if __FILE__ == $0
  rulebook = NFARulebook.new(
      [
          FARule.new(1, 'a', 1), FARule.new(1, 'b', 1), FARule.new(1, 'b', 2),
          FARule.new(2, 'a', 3), FARule.new(2, 'b', 3),
          FARule.new(3, 'a', 4), FARule.new(3, 'b', 4)
      ])
  nfaDesign = NFADesign.new(1, [4], rulebook)
  puts nfaDesign.accepting?('bab')
  puts nfaDesign.accepting?('bbbbb')
  puts nfaDesign.accepting?('bbabb')

end