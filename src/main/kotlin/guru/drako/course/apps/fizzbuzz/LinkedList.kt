package guru.drako.course.apps.fizzbuzz


class LinkedList<ItemType> {
  inner class Item(
    var value: ItemType,
    var next: Item? = null
  )

  private var head: Item? = null

  fun isEmpty() = head == null
  fun isNotEmpty() = head != null

  fun add(value: ItemType) {
    var current = head
    while (current?.next != null) {
      current = current.next
    }

    if (current != null) {
      current.next = Item(value)
    } else {
      head = Item(value)
    }
  }
}

fun <ItemType> linkedListOf(vararg items: ItemType): LinkedList<ItemType> {
  val l = LinkedList<ItemType>()
  for (item in items) {
    l.add(item)
  }
  return l
}

open class Base
class Derived : Base()

fun main() {
  val l: LinkedList<Base> = linkedListOf(Derived())
}
