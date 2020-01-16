require '../small_step_semantic.rb'
require '../machine.rb'

expression1 = Add.new(
    Multiply.new(Number.new(1), Number.new(2)),
    Multiply.new(Number.new(3), Number.new(4))
)
Machine.new(expression1, {}).run