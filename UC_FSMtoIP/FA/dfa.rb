require './fa_rule'

class DFARulebook < Struct.new(:rules)
  def next_state(state, character)
    rule_for(state, character).follow
  end

  def rule_for(state, character)
    rules.detect { |rule| rule.applies_to?(state, character) }
  end
end

class DFA < Struct.new(:current_state, :accept_states, :rulebook)
  def accepting?
    accept_states.include?(current_state)
  end

  def read_character(character)
    self.current_state = rulebook.next_state(self.current_state, character)
  end

  def read_string(string)
    string.chars.each { |character|
      read_character(character)
    }
  end
end

class DFADesign < Struct.new(:current_state, :accept_states, :rulebook)
  def to_dfa
    DFA.new(current_state, accept_states, rulebook)
  end

  def accepting?(string)
    to_dfa.tap { |dfa|
      dfa.read_string(string)
    }.accepting?
  end
end

if __FILE__ == $0
  rulebook = DFARulebook.new(
      [
          FARule.new(1, 'a', 2), FARule.new(1, 'b', 1),
          FARule.new(2, 'a', 2), FARule.new(2, 'b', 3),
          FARule.new(3, 'a', 3), FARule.new(3, 'b', 3)
      ])

  #test DFA
  # dfa = DFA.new(1, [3], rulebook)
  # dfa.read_string('baaab')
  # puts dfa.accepting?

  #test DFADesign
  puts DFADesign.new(1, [3], rulebook).accepting?('bb')
  puts DFADesign.new(1, [3], rulebook).accepting?('baaab')


end