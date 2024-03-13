package five;
class Car {
    private String NameCar;
    private int Age;
    private int Speed;
    public Car(String NameCar, int Age, int Speed){
        this.NameCar = NameCar;
        this.Age = Age;
        this.Speed = Speed;
    }
    public int getAge(){
        return Age;
    }

}