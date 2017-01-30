
package lebara.interview

import scala.collection.mutable.ListBuffer

case class User(`name`: String, `orders`: Order)
case class Order(`product`: List[Product])
case class Product(`name`: String, `price`: Double, `category`: String)
object Driver extends ScalaInterview {
  def main(args: Array[String]) {
    var product1 = new Product("scala", 100, "FOO Programing")
    var product2 = new Product("java", 200, "OO Programing")
    var product3 = new Product("c++", 100, "OO Programing")
    var product4 = new Product("javascript", 200, "OO Programing")
    
    var prodList: List[Product] = List(product1, product2,product3,product4)
    var order = new Order(prodList)

    var user = new User("sandeep", order)
    
    val names = productNamesFromOrder(order)
    println("product names from order:"+names)
    
    val listOfProduct = productsFromUser(user)
    println("List of orders from user:"+listOfProduct)
    
    val total:Double = orderTotal(order)
    println("Total cost:"+total)

    var productinCat = productsInCategory(prodList, "OO Programing")
    println("Product list based on selected category:"+productinCat)
    
    var cat = productsByCategory(prodList)
    println("Product List based on catogiry wise:"+cat)
  }
  def productNamesFromOrder(order: Order): List[String] = {
    var prodList: List[Product] = order.product
    var names = new ListBuffer[String]()
    for (i <- 0 to prodList.length - 1) {
      names += prodList(i).name
    }
    names.toList
  }
  def productsFromUser(user: User): List[Product] = {
    if (user != null) {
      var order = user.orders
      order.product
    } else
      null
  }
  def orderTotal(order: Order): Double = {
    var total = 0.0
    var prodList: List[Product] = order.product
    for (i <- 0 to prodList.length - 1) {
      total = total + prodList(i).price
    }
    total
  }
  def productsInCategory(products: List[Product], category: String): List[Product] = {
    var listOfProducts: ListBuffer[Product] = new ListBuffer[Product]()
    for(i <- 0 to products.length - 1) {
      var cat = products(i).category
      if(category.equals(cat)){
        listOfProducts += products(i)
      }
    }
    listOfProducts.toList
  }

  def productsByCategory(products: List[Product]): Map[String, List[Product]] = {
    var catMap = scala.collection.mutable.Map[String, ListBuffer[Product]]()
    var finalMap = scala.collection.mutable.Map[String, List[Product]]()

    for (i <- 0 to products.length - 1) {
      var cat = products(i).category
      var listOfProducts: ListBuffer[Product] = new ListBuffer[Product]()
      if (catMap.contains(cat)) {
        listOfProducts = catMap.get(cat).get
        finalMap.remove(cat)
        catMap.remove(cat)
      }
      listOfProducts += products(i)
      finalMap += (cat -> listOfProducts.toList)
      catMap += (cat -> listOfProducts)
    }
    Map() ++ finalMap
  }

}
