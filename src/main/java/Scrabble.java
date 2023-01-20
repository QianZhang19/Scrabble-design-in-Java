public class Scrabble {
    private String word;
    private Character[] chars1;
    private Character[] chars2;
    private boolean doubleWord;
    private boolean tripleWord;
    private int score;


    public Scrabble(String word, Character[] chars1, Character[] chars2, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.chars1 = chars1;
        this.chars2 = chars2;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
    }

    public Scrabble(String word) {
        this.word = word;
    }


    public int score() {

        if (word == null || word.length() == 0) {
            return 0;
        }

        if (word != null && word.length() > 0) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.toUpperCase().charAt(i);
                this.score += points(letter);
            }
        }

        // extended criteria
        for (int i = 0; i < chars1.length; i++) {
            this.score += points(chars1[i]);
        }

        for (int i = 0; i < chars2.length; i++) {
            this.score += points(chars2[i]);
        }

        // extended criteria
        if (this.doubleWord) {
            this.score = this.score * 2;
        }

        if (this.tripleWord) {
            this.score = this.score * 2;
        }
        return score;
    }


    public int points(char letter) {
        int points = 0;
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' || letter == 'L' || letter == 'N' || letter == 'R' || letter == 'S' || letter == 'T') {
            points += 1;
        } else if (letter == 'D' || letter == 'G') {
            points += 2;
        } else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P') {
            points += 3;
        } else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W' || letter == 'Y') {
            points += 4;
        } else if (letter == 'K') {
            points += 5;
        } else if (letter == 'J' || letter == 'X') {
            points += 8;
        } else {
            points += 10;
        }
        return points;
    }
}





