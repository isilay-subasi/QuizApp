package com.isilsubasi.quizapp.model;

public class QuestionAndroidLibrary {

    public String questions[]={
            "Android soru 1",
            "Android soru 2",
            "Android soru 3",
            "Android soru 4",
            "Android soru 5",
            "Android soru 6",
            "Android soru 7",
            "Android soru 8",
            "Android soru 9",
            "Android soru 10",
    };

    public String choices[][]={

            {"a","b","c","d"},
            {"2a","2b","2c","2d"},
            {"3a","3b","3c","3d"},
            {"4a","4b","4c","4d"},
            {"5a","5b","5c","5d"},
            {"6a","6b","6c","6d"},
            {"7a","7b","7c","7d"},
            {"8a","8b","8c","8d"},
            {"9a","9b","9c","9d"},
            {"10a","10b","10c","10d"},
    };

    public String correctAnswer[]={

            "a",
            "2b",
            "3c",
            "4d",
            "5b",
            "6a",
            "7c",
            "8d",
            "9a",
            "10d",


    };


    public String getQuestion(int number){

        String question=questions[number];
        return question;

    }

    public String getChoiceOne(int number){
        String choice=choices[number][0];
        return choice;


    }

    public String getChoiceTwo(int number){
        String choice=choices[number][1];
        return choice;


    }


    public String getChoiceThree(int number){
        String choice=choices[number][2];
        return choice;


    }
    public String getChoiceFour(int number){
        String choice=choices[number][3];
        return choice;


    }

    public String getCorrectAnswer(int number){
        String answer = correctAnswer[number];
        return answer;
    }



}
