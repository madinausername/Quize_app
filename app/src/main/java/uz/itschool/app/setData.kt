package uz.itschool.app

object setData {
    const val name:String="name"
    const val score:String="score"
    fun getQuestion():ArrayList<Question_Data>{
        var que:ArrayList<Question_Data> = arrayListOf()
        var q1=Question_Data(
            "Which element is found more in Earth?",
            1,
            "Nitrogen", "Oxygen","Hydrogen","Litium",
            2
        )
        var q2=Question_Data(
            "What is the diameter of Sun?",
            2,
            "1,392,684 km","145,263,987 km","2,598,745 km","5,392,684 km",
            1
        )
        var q3=Question_Data(
            "At how much speed Moon moves across the Sun?",
            3,
            "4,250 km per hour",
            "250 km per hour",
            "2,250 km per hour",
            "5,250 km per hour",
            3
        )
        var q4=Question_Data(
            "Solve the problem:  1+0=?",
            4,"1","0","10","2",
            1
        )
        var q5=Question_Data(
            "Solve the problem:  1*0=?",
            5,
            "0", "1","10","01",
            1

        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)


        return que
    }
}