class MyClass
    def my_method
        @v = 100
    end
end

obj = MyClass.new
puts obj.class
puts obj.instance_variables.length # 0
puts obj.my_method # 100
puts obj.instance_variables.length # 1

puts ''.class
puts ''.class.class
puts ''.class.class.class