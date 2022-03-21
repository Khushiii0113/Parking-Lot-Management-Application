package Project

import scala.math._

class Vehicle (vehicleNo: String, entryTime: Time, floor: Parking, parkingSpot: Int) {
  def getInfo(currentTime: Time): Unit ={
    val  duration = abs(currentTime.minus(entryTime))
    println(s"Vehicle No: $vehicleNo")
    println(s"Parking spot: $parkingSpot")
    println(s"Parking duration: $duration minutes")
  }
}

class twoWheeler(val vehicleNo: String, val entryTime: Time, val floor: Parking, val parkingSpot: Int) extends Vehicle(vehicleNo, entryTime, floor, parkingSpot) {
  floor.twoWheelerSpots = floor.twoWheelerSpots + 1
  if(floor.twoWheelerSpots > floor.maxTwoWheelers){
    floor.twoWheelerSpots = floor.twoWheelerSpots - 1
    throw new Exception("The parking lot is full")
  }

  def exit(exitTime: Time): Unit ={
    floor.twoWheelerSpots = floor.twoWheelerSpots - 1
    val duration = abs(exitTime.minus(entryTime))
    val hours = ceil(duration/60)
    if(hours <= 2){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 20")
    }
    else if (hours > 2 && hours <= 4){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 40")
    }
    else{
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 75")
    }
  }
}

class car(val vehicleNo: String, val entryTime: Time, val floor: Parking, val parkingSpot: Int) extends Vehicle(vehicleNo, entryTime, floor, parkingSpot) {
  floor.carSpots = floor.carSpots + 1
  if(floor.carSpots > floor.maxCars){
    floor.carSpots = floor.carSpots - 1
    throw new Exception("The parking lot is full")
  }

  def exit(exitTime: Time): Unit ={
    floor.carSpots = floor.carSpots - 1
    val duration = abs(exitTime.minus(entryTime))
    val hours = ceil(duration/60)
    if(hours <= 2){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 50")
    }
    else if (hours > 2 && hours <= 4){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 100")
    }
    else{
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 150")
    }
  }
}

class SUV(val vehicleNo: String, val entryTime: Time, val floor: Parking, val parkingSpot: Int) extends Vehicle(vehicleNo, entryTime, floor, parkingSpot) {
  floor.SUVSpots = floor.SUVSpots + 1
  if(floor.SUVSpots > floor.maxSUVs){
    floor.SUVSpots = floor.SUVSpots - 1
    throw new Exception("The parking lot is full")
  }

  def exit(exitTime: Time): Unit ={
    floor.SUVSpots = floor.SUVSpots - 1
    val duration = abs(exitTime.minus(entryTime))
    val hours = ceil(duration/60)
    if(hours <= 2){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 100")
    }
    else if (hours > 2 && hours <= 4){
      println(s"Duration: $hours hours/ $duration minutes. Please pay Rs. 200")
    }
    else{
      println(s"Duration: $hours hours / $duration minutes. Please pay Rs. 300")
    }
  }
}

