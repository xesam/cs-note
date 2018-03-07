require '../small_step_semantic/small_step_semantic'

#expression
class Number
  def evaluate(environment)
    self
  end
end

class Boolean
  def evaluate(environment)
    self
  end
end

class Variable
  def evaluate(environment)
    environment[name]
  end
end

class Add
  def evaluate(environment)
    Number.new(left.evaluate(environment).value + right.evaluate(environment).value)
  end
end

class Multiply
  def evaluate(environment)
    Number.new(left.evaluate(environment).value * right.evaluate(environment).value)
  end
end

class LessThan
  def evaluate(environment)
    Boolean.new(left.evaluate(environment).value < right.evaluate(environment).value)
  end
end

#statement
class Assign
  def evaluate(environment)
    environment.merge({name => expression.evaluate(environment)})
  end
end

class Sequence
  def evaluate(environment)
    second.evaluate(first.evaluate(environment))
  end
end

class If
  def evaluate(environment)
    if condition.evaluate(environment)
      consequence.evaluate(environment)
    else
      alternative.evaluate(environment)
    end
  end
end

class While
  def evaluate(environment)
    case condition.evaluate(environment)
      when Boolean.new(true)
        self.evaluate(body.evaluate(environment))
      when Boolean.new(false)
        environment
    end
  end
end

if __FILE__ == $0
  statement = While.new(
      LessThan.new(Variable.new(:x), Number.new(3)),
      Assign.new(:x, Add.new(Variable.new(:x), Number.new(1))),
  )
  puts statement
  environment = statement.evaluate({:x => Number.new(1)})
  puts environment
end

