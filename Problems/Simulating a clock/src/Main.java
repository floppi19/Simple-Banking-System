class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        minutes++;
        if (minutes > 59) {
            hours++;
            minutes = 0;
            if (hours > 12) {
                hours = 1;
            }
        }
    }
}