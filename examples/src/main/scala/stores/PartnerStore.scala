package stores

import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Singleton

import org.coursera.example.Instructor
import org.coursera.example.Partner
import org.coursera.naptime.model.Keyed

@Singleton
class PartnerStore {
  @volatile
  var partnerStore = Map.empty[String, Partner]
  val nextId = new AtomicInteger(0)

  partnerStore = partnerStore + (
    "stanford" -> Partner(
      courseIds = List("ml"),
      instructorIds = List(6, 3, 4, 2, 5, 1),
      name = "Stanford University",
      homepage = ""),
    "ucsd" -> Partner(
      courseIds = List("lhtl"),
      instructorIds = List(1, 4, 2, 5, 7, 3, 8, 6),
      name = "UCSD",
      homepage = ""))


  def get(id: String) = partnerStore.get(id)

  def create(partner: Keyed[String, Partner]): Unit = {
    partnerStore = partnerStore + (partner.key -> partner.value)
  }

  def all() = partnerStore
}
