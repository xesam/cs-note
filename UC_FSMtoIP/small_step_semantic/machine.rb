class Machine < Struct.new(:statement, :environment)
  def step
    self.statement, self.environment = self.statement.reduce(environment)
  end

  def run
    while self.statement.reducible?
      puts "#{statement}, #{environment}"
      step
    end
    puts "#{statement}, #{environment}"
  end
end