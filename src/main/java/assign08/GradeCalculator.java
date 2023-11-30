package assign08;

import java.util.NoSuchElementException;

/**
 * This class is a grade calculator class.
 *
 * @author Josh Eggett
 * @version 1.1
 */
public class GradeCalculator {

    /**
     * declare instance variables.
     */
    private DynamicArray examScores;
    private DynamicArray assignmentScores;
    private DynamicArray labScores;
    private DynamicArray quizScores;

    public GradeCalculator() {
        examScores = new DynamicArray();
        assignmentScores = new DynamicArray();
        labScores = new DynamicArray();
        quizScores = new DynamicArray();
    }

    /**
     * Add an exam score to the list.
     *
     * @param score The exam score to be added.
     */
    public void addExamScore(int score) {
        this.examScores.append(score);
    }

    /**
     * Add an assignment score to the list.
     *
     * @param score The assignment score to be added.
     */
    public void addAssignmentScore(int score) {
        this.assignmentScores.append(score);
    }

    /**
     * Add a lab score to the list.
     *
     * @param score The lab score to be added.
     */
    public void addLabScore(int score) {
        this.labScores.append(score);
    }

    /**
     * Add a quiz score to the list.
     *
     * @param score The quiz score to be added.
     */
    public void addQuizScore(int score) {
        this.quizScores.append(score);
    }

    /**
     * Get the average assignment score of the assignments stored in the class.
     *
     * @return the average assignment score.
     */
    public double getAverageAssignmentScore() {
        if (assignmentScores.size() == 0) {
            throw new NoSuchElementException();
        }
        double assignmentAvg = 0;
        for (int i = 0; i < assignmentScores.size(); i++) {
            assignmentAvg += assignmentScores.getElement(i);
        }
        return (assignmentAvg / assignmentScores.size());
    }

    /**
     * Get the average exam score of the assignments stored in the class.
     *
     * @return the average exam score.
     */
    public double getAverageExamScore() {
        if (examScores.size() == 0) {
            throw new NoSuchElementException();
        }
        double examAvg = 0;
        for (int i = 0; i < examScores.size(); i++) {
            examAvg += examScores.getElement(i);
        }
        return (examAvg / examScores.size());
    }

    /**
     * Get the average quiz score of the assignments stored in the class.
     *
     * @return the average quiz score.
     */
    public double getAverageQuizScore() {
        if (quizScores.size() == 0) {
            throw new NoSuchElementException();
        }
        double quizAvg = 0;
        for (int i = 0; i < quizScores.size(); i++) {
            quizAvg += quizScores.getElement(i);
        }
        return (quizAvg / quizScores.size());
    }

    /**
     * Get the average lab score of the assignments stored in the class.
     *
     * @return the average lab score.
     */
    public double getAverageLabScore() {
        if (labScores.size() == 0) {
            throw new NoSuchElementException();
        }
        double labAvg = 0;
        for (int i = 0; i < labScores.size(); i++) {
            labAvg += labScores.getElement(i);
        }
        return (labAvg / labScores.size());
    }

    /**
     * Get the median assignment score of the assignments stored in the class.
     *
     * @return the median assignment score.
     */
    public int getMedianAssignmentScore() {
        assignmentScores.sort();
        int medianAssignment;
        if (assignmentScores.size() % 2 == 0) { // check if its an even sized array
            medianAssignment = assignmentScores.getElement((assignmentScores.size() / 2) - 1);
        } else {
            medianAssignment = assignmentScores.getElement(assignmentScores.size() / 2);
        }
        return medianAssignment;
    }

    /**
     * Get the number of 0 assignment scores of the assignments stored in the class.
     *
     * @return the number of 0 assignment scores.
     */
    public int getNumberOfZeroAssignmentScores() {
        int numZerAssignmentScores = 0;
        for (int i = 0; i < assignmentScores.size(); i++) {
            if (assignmentScores.getElement(i) == 0) {
                numZerAssignmentScores++;
            }
        }
        return numZerAssignmentScores;
    }

    /**
     * Get the highest assignment score of the assignments stored in the class.
     *
     * @return the highest assignment score.
     */
    public int getHighestAssignmentScore() {
        int highestScore = 0;
        for (int i = 0; i < assignmentScores.size(); i++) {
            if (assignmentScores.getElement(i) > highestScore) {
                highestScore = assignmentScores.getElement(i);
            }
        }
        return highestScore;
    }

    /**
     * Get the lowest assignment score of the assignments stored in the class.
     *
     * @return the lowest assignment score.
     */
    public int getLowestAssignmentScore() {
        int lowestScore = 999999999; // initialize to a big number just to make sure that we don't return the initialized value.
        for (int i = 0; i < assignmentScores.size(); i++) {
            if (assignmentScores.getElement(i) < lowestScore) {
                lowestScore = assignmentScores.getElement(i);
            }
        }
        return lowestScore;
    }

    /**
     * Get the numeric course grade as an int associated with the stored scores.
     *
     * @return the course grade as an integer.
     */
    public int getCourseGradeNumeric() {
        int courseGrade = 0;
        double examAverages = getAverageExamScore();
        double averageAssignmentScores = getAverageAssignmentScore();
        double labAverages = getAverageLabScore();
        double weeklyQuizAverages = getAverageQuizScore();
        if (examAverages >= 65) {
            courseGrade = (int) (.45 * (examAverages) + .35 * averageAssignmentScores + .1 * labAverages + .1 * weeklyQuizAverages);
        } else {
            courseGrade = (int) examAverages;
        }
        return courseGrade;
    }

    /**
     * Get the letter grade associated with the scores stored.
     *
     * @return the letter grade of the course
     */
    public String getCourseGradeLetter() {
        int courseGrade = getCourseGradeNumeric();
        String gradeLetter = "";
        if (courseGrade < 60) {
            gradeLetter = "E";
        } else if (courseGrade < 63) {
            gradeLetter = "D-";
        } else if (courseGrade < 67) {
            gradeLetter = "D";
        } else if (courseGrade < 70) {
            gradeLetter = "D+";
        } else if (courseGrade < 73) {
            gradeLetter = "C-";
        } else if (courseGrade < 77) {
            gradeLetter = "C";
        } else if (courseGrade < 80) {
            gradeLetter = "C+";
        } else if (courseGrade < 83) {
            gradeLetter = "B-";
        } else if (courseGrade < 87) {
            gradeLetter = "B";
        } else if (courseGrade < 90) {
            gradeLetter = "B+";
        } else if (courseGrade < 93) {
            gradeLetter = "A-";
        } else if (courseGrade < 100) {
            gradeLetter = "A";
        }
        return gradeLetter;
    }
}
