require './nfa'

class NFARulebook
  def follow_free_move(states)
    more_states = self.next_states(states, nil)
    if more_states.subset? states
      states
    else
      follow_free_move(states + more_states)
    end
  end
end

class NFA
  def current_states
    rulebook.follow_free_move(super)
  end
end

if __FILE__ == $0
  rulebook = NFARulebook.new(
      [
          FARule.new(1, nil, 2), FARule.new(1, nil, 4),
          FARule.new(2, 'a', 3),
          FARule.new(3, 'a', 2),
          FARule.new(4, 'a', 5),
          FARule.new(5, 'a', 6),
          FARule.new(6, 'a', 4)
      ])
  nfaDesign = NFADesign.new(1, [2, 4], rulebook)
  puts nfaDesign.accepting?('aa')
  puts nfaDesign.accepting?('aaa')
  puts nfaDesign.accepting?('aaaa')
  puts nfaDesign.accepting?('aaaaa')
  puts nfaDesign.accepting?('aaaaaa')
end