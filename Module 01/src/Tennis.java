class Tennis {
    private int scorePlayer1, scorePlayer2;

    Tennis() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    String point(int player) {
        if (player == 1) {
            if (scorePlayer1 < 30)
                scorePlayer1 += 15;
            else
                scorePlayer1 += 10;
        } else if (player == 2) {
            if (scorePlayer2 < 30)
                scorePlayer2 += 15;
            else
                scorePlayer2 += 10;
        } else
            return scorePlayer1 + " - " + scorePlayer2;
        return getScore();
    }

    private String getScore() {
        if (scorePlayer1 == scorePlayer2 && scorePlayer1 >= 40)
            return "Deuce";
        if (scorePlayer1 <= 40 && scorePlayer2 <= 40)
            return String.format("%s - %s", scorePlayer1, scorePlayer2);

        if (scorePlayer1 - scorePlayer2 >= 20)
            return "Spill vunnet av spiller 1";
        if (scorePlayer1 - scorePlayer2 >= 10)
            return "Fordel til spiller 1";
        if (scorePlayer1 - scorePlayer2 >= -10)
            return "Fordel til spiller 2";
        if (scorePlayer1 - scorePlayer2 >= -20)
            return "Spill vunnet av spiller 2";
        else return String.format("%s - %s", scorePlayer1, scorePlayer2);
    }
}
