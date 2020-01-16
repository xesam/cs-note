require '../small_step_semantic.rb'
require '../machine.rb'

Machine.new(
    While.new(
        LessThan.new(Variable.new(:x), Number.new(5)),
        Assign.new(:x, Multiply.new(Variable.new(:x), Number.new(3))),
    ),
    {:x => Number.new(1)}
).run