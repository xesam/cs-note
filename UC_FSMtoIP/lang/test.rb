class Point < Struct.new :name, :birthday

end

point = Point.new('xesam', 1987)
puts point.name
puts point.birthday

#proc
a = -> e { puts e }

a.call(2)

