package stores

import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Singleton

import org.coursera.example.Instructor
import org.coursera.naptime.model.Keyed

@Singleton
class InstructorStore {
  @volatile
  var instructorStore = Map.empty[Int, Instructor]
  val nextId = new AtomicInteger(0)

  instructorStore = instructorStore + (
    1 -> Instructor(
      partner = "stanford",
      name = "Andrew Ng",
      photoUrl = ""),
    2 -> Instructor(
      partner = "ucsd",
      name = "Barb Oakley",
      photoUrl = ""),
    3 -> Instructor(
      partner = "ucsd3",
      name = "Barb Oakley3",
      photoUrl = ""),
    4 -> Instructor(
      partner = "ucsd4",
      name = "Barb Oakley4",
      photoUrl = ""),
    5 -> Instructor(
      partner = "ucsd5",
      name = "Barb Oakley5",
      photoUrl = ""),
    6 -> Instructor(
      partner = "ucsd6",
      name = "Barb Oakley6",
      photoUrl = ""),
    7 -> Instructor(
      partner = "ucsd7",
      name = "Barb Oakley7",
      photoUrl = ""),
    8 -> Instructor(
      partner = "ucsd8",
      name = "Barb Oakley8",
      photoUrl = ""))


  def get(id: Int) = instructorStore.get(id)

  def create(instructor: Keyed[Int, Instructor]): Unit = {
    instructorStore = instructorStore + (instructor.key -> instructor.value)
  }

  def all() = instructorStore
}
