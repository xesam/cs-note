require '../small_step_semantic.rb'
require '../machine.rb'

Machine.new(
    Sequence.new(
        Assign.new(:x, Number.new(1)),
        Assign.new(:y, Add.new(Variable.new(:x), Number.new(3)))
    ),
    {}
).run