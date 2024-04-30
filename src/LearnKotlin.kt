import java.lang.Integer.max

var start = 34;
private fun getNextPageInfo(headerData: String?): String? {
    var linkData = headerData
    if(linkData == null || headerData == "")
        return null
    if(!linkData.contains("rel=\"next\"")) {
        return null
    }
    if(linkData.contains("rel=\"previous\"")) {
        linkData = linkData.split("rel=\"previous\"")[1]
    }
    return linkData.split("page_info=")[1].split(">;")[0]
}

class Learn(var one:Int, var two:Int) {}
fun main() {
    var str = "<https://datondev.myshopify.com/admin/api/2019-10/orders.json?limit=10&page_info=eyJkaXJlY3Rpb24iOiJwcmV2Iiwic3RhdHVzIjoiYW55IiwidXBkYXRlZF9hdF9taW4iOiIyMDE4LTA4LTI5IDEyOjAwOjQ4IFVUQyIsImxhc3RfaWQiOjEyMDk0OTQ3MzI4OTgsImxhc3RfdmFsdWUiOiIyMDE5LTA2LTEzIDEwOjIyOjE2In0%3D>; rel=\"previous\","

    println(max(2,3))
}