var current: Char = 'X'
var arrayOX: Array<Array<String>> = arrayOf(
    arrayOf(" ", "1", "2", "3"),
    arrayOf("1", "-", "-", "-"),
    arrayOf("2", "-", "-", "-"),
    arrayOf("3", "-", "-", "-")
)
fun main() {

    println("Welcome to OX Game")
    OXplay(arrayOX)
}
fun OXplay(arrayOX:Array<Array<String>>){
    if(checkOWin()){
        println("O win!!")
    } else if(checkXWin()) {
        println("X win!!")
    } else if(!checkDraw()) {
        println("Draw!!")
    } else {
        for (row: Array<String> in arrayOX){
            for (col:String in row){
                print("$col ")
            }
            println()
        }

        println("${current} turn")  //split funtion
        print("Please input Row: Col: ")
        val input : String? = readLine()
        println()
        input(input)
    }
}

fun checkDraw(): Boolean {
    for (row: Array<String> in arrayOX){
        for (col:String in row){
            if(col.equals("-")){
                return true
            }

        }
    }
    return false
}

fun checkXWin(): Boolean {
    return (arrayOX[1][1].equals("X") &&
            arrayOX[2][1].equals("X") &&
            arrayOX[3][1].equals("X")) ||
            (arrayOX[1][2].equals("X") &&
                    arrayOX[2][2].equals("X") &&
                    arrayOX[3][2].equals("X")) ||
            (arrayOX[1][3].equals("X") &&
                    arrayOX[2][3].equals("X") &&
                    arrayOX[3][3].equals("X")) ||

            (arrayOX[1][1].equals("X") &&
                    arrayOX[1][2].equals("X") &&
                    arrayOX[1][3].equals("X")) ||
            (arrayOX[2][1].equals("X") &&
                    arrayOX[2][2].equals("X") &&
                    arrayOX[2][3].equals("X")) ||
            (arrayOX[3][1].equals("X") &&
                    arrayOX[3][2].equals("X") &&
                    arrayOX[3][3].equals("X")) ||

            (arrayOX[1][1].equals("X") &&
                    arrayOX[2][2].equals("X") &&
                    arrayOX[3][3].equals("X")) ||
            (arrayOX[1][3].equals("X") &&
                    arrayOX[2][2].equals("X") &&
                    arrayOX[3][1].equals("X"))
}

fun checkOWin(): Boolean {
    return (arrayOX[1][1].equals("O") &&
            arrayOX[2][1].equals("O") &&
            arrayOX[3][1].equals("O")) ||
            (arrayOX[1][2].equals("O") &&
                    arrayOX[2][2].equals("O") &&
                    arrayOX[3][2].equals("O")) ||
            (arrayOX[1][3].equals("O") &&
                    arrayOX[2][3].equals("O") &&
                    arrayOX[3][3].equals("O")) ||

            (arrayOX[1][1].equals("O") &&
                    arrayOX[1][2].equals("O") &&
                    arrayOX[1][3].equals("O")) ||
            (arrayOX[2][1].equals("O") &&
                    arrayOX[2][2].equals("O") &&
                    arrayOX[2][3].equals("O")) ||
            (arrayOX[3][1].equals("O") &&
                    arrayOX[3][2].equals("O") &&
                    arrayOX[3][3].equals("O")) ||

            (arrayOX[1][1].equals("O") &&
                    arrayOX[2][2].equals("O") &&
                    arrayOX[3][3].equals("O")) ||
            (arrayOX[1][3].equals("O") &&
                    arrayOX[2][2].equals("O") &&
                    arrayOX[3][1].equals("O"))
}

fun input(i: String?){
    try {
        val rcList : List<String>? = i?.split(" ")
        if(rcList?.size != 2){
            println("Error: Must input 2 number R C ")
            OXplay(arrayOX)
        } else {
            val rowInd: Int = rcList.get(0).toInt()
            val colInd: Int = rcList.get(1).toInt()
            check(rowInd, colInd)
        }
    } catch (t: Throwable){
        println("Error: ${t.message} Must be numbers R C (Ex: 1 2)")
        OXplay(arrayOX)
    }

}

fun check(i: Int, j: Int){
    if ((i < 4 && i > 0) && (j < 4 && j > 0) && (arrayOX[i][j].equals("-"))){
        arrayOX[i][j] = "${current}"
        switchCurrent(current)
        OXplay(arrayOX)
    } else {
        println("Input Error")
        OXplay(arrayOX)
    }
}

fun switchCurrent(char: Char){
    if (char.equals('X')){
        current = 'O'
    }else{
        current = 'X'
    }
}
