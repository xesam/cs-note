require '../small_step_semantic/small_step_semantic.rb'
require './machine.rb'

# expression1 = Add.new(
#     Multiply.new(Number.new(1), Number.new(2)),
#     Multiply.new(Number.new(3), Number.new(4))
# )
# Machine.new(expression1, {}).run
#
# expression2 = LessThan.new(
#     Multiply.new(Number.new(1), Number.new(2)),
#     Multiply.new(Number.new(3), Number.new(4))
# )
# Machine.new(expression2, {}).run

# Machine.new(Assign.new(:x, Add.new(Variable.new(:x), Number.new(3))), {:x => Number.new(2)}).run

# Machine.new(
#     If.new(
#         Variable.new(:x),
#         Assign.new(:y, Number.new(1)),
#         Assign.new(:y, Number.new(2))
#     ),
#     {:x => Boolean.new(false)}
# ).run

#test Sequence
# Machine.new(
#     Sequence.new(
#         Assign.new(:x, Number.new(1)),
#         Assign.new(:y, Add.new(Variable.new(:x), Number.new(3)))
#     ),
#     {}
# ).run

#test While
Machine.new(
    While.new(
        LessThan.new(Variable.new(:x), Number.new(3)),
        Assign.new(:x, Add.new(Variable.new(:x), Number.new(1))),
    ),
    {:x => Number.new(1)}
).run
