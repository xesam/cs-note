require '../small_step_semantic.rb'
require '../machine.rb'

puts '### if-else'

Machine.new(
    If.new(
        Variable.new(:x),
        Assign.new(:y, Number.new(1)),
        Assign.new(:y, Number.new(2))
    ),
    {:x => Boolean.new(false)}
).run

puts '### if'

Machine.new(
    If.new(
        Variable.new(:x),
        Assign.new(:y, Number.new(1)),
        DoNothing.new()
    ),
    {:x => Boolean.new(false)}
).run