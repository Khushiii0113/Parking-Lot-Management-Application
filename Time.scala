package Project

class Time(hours: Int = 0, minutes: Int = 0) {
  require(hours >= 0 && hours < 24, "Hours should be within 0 and 24")
  require(minutes >= 0 && minutes < 60, "Minutes should be withing 0 and 59")

  val asMinutes = hours * 60 + minutes

  def minus(that:Time): Int = asMinutes - that.asMinutes
}
