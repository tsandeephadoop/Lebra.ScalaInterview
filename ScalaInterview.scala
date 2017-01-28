package lebara.interview

/**
  * Scala test v1.
  *
  * We have the following simplistic data model representing an e-commerce business:
  *
  * A user has a name and a list of orders. All attributes are required.
  *
  * An order is comprised of a list of products along with associated quantities.
  *
  * A product has a name, price and category. All attributes are required, except for category.
  *
  * Develop a representation of this data model and implement the following methods in Scala.
  * Include any code you developed in support of your solution.
  */

trait ScalaInterview {

  // 1 - Given an order, produce a list of product names.
  def productNamesFromOrder(order: Order): List[String]

  // 2 - Given a user, produce a list of products from all of their orders.
  def productsFromUser(user: User): List[Product]

  // 3 - Given an order, calculate the total price.
  def orderTotal(order: Order): Double

  // 4 - Given a list of products and a category name, produce a list of products in that category.
  // Make sure the solution handles a possibly missing category on a product.
  def productsInCategory(products: List[Product], category: String): List[Product]

  // 5 - Given list of products, produce a map of category to a list of products in that category.
  // Make sure the solution handles a possibly missing category on a product.
  def productsByCategory(products: List[Product]): Map[String, List[Product]]
}
