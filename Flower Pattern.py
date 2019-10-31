import turtle

def make_circle(circle,radius):
    circle.circle(radius)
    
def make_flower():
    flower = turtle.Turtle()
    
    

    turtle.Screen().bgcolor("blue")
    flower.color("pink")
    flower.speed(0)
    flower.shape("circle")

    flower.right(135)
    for i in range(37):
        for j in range(5):
            make_circle(flower,i*2)
            flower.left(90)
        
    
    flower.right(45)
    flower.color("green")
    flower.forward(250)
make_flower()

