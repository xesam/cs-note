require '../small_step_semantic.rb'
require '../machine.rb'

Machine.new(Assign.new(:x, Add.new(Variable.new(:x), Number.new(3))), {:x => Number.new(2)}).run
