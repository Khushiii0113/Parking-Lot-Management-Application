import Project._
import org.scalatest.matchers.must.Matchers.{be, noException}

class ParkingLotTest extends org.scalatest.funsuite.AnyFunSuite{
  val floor1 = Parking(1,3,2)
  val bike1= new twoWheeler("Bike1", Time(10,30) ,floor1, 0)
  test("Bike parking is full"){
    assertThrows[Exception]{val bike2= new twoWheeler("Bike2", Time(10,45) ,floor1, 1)}
  }
  test("Allow entry of bike when another exits"){
    noException should be thrownBy {
      bike1.exit(exitTime = Time(13,30));
      val bike2= new twoWheeler("Bike2", Time(10,45) ,floor1, 1)}
  }
  val car1= new car("Car1", Time(10,30) ,floor1, 0)
  val car2= new car("Car2", Time(11,15) ,floor1, 1)
  val car3= new car("Car3", Time(12,30) ,floor1, 2)

  test("Car parking is full"){
    assertThrows[Exception]{val car4= new car("Car4", entryTime = Time(10,30) ,floor1, 3)}
  }
  test("Allow entry of car when another exits"){
    noException should be thrownBy {
      car3.exit(Time(14,30));
      val car4= new car("Car4", entryTime = Time(10,30) ,floor1, 2)}
  }
  val suv1= new SUV("SUV1", entryTime = Time(10,30) ,floor1, 0)
  val suv2= new SUV("SUV2", Time(10,30) ,floor1, 1)

  test("SUV parking is full"){
    assertThrows[Exception]{val suv3= new SUV("SUV3", entryTime = Time(10,30) ,floor1, 2)}
  }
  test("Allow entry of SUV when another exits"){
    noException should be thrownBy {
      suv2.exit(Time(12,45));
      val suv3= new SUV("SUV3", entryTime = Time(10,30) ,floor1, 3)}
  }
  test("Bike1 info"){
    assertResult(println("Bike1 info")){bike1.getInfo(Time(12,20))}
  }
  test("Car1 info"){
    assertResult(println("Car1 info")){car1.getInfo(Time(11,30))}
  }
  test("Car2 info"){
    assertResult(println("Car2 info")){car2.getInfo(Time(12,30))}
  }
  test("Car3 info"){
    assertResult(println("Car3 info")){car3.getInfo(Time(13,30))}
  }
  test("SUV1 info"){
    assertResult(println("SUV1 info")){suv1.getInfo(Time(11,15))}
  }
  test("SUV2 info"){
    assertResult(println("SUV2 info")){suv2.getInfo(Time(12,15))}
  }
}
