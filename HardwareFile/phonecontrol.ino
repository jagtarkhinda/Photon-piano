// This #include statement was automatically added by the Particle IDE.
#include <InternetButton.h>

// create an internet button object
InternetButton button = InternetButton();



InternetButton b = InternetButton();


void setup() {

    b.begin();
    Particle.function("sound", getPianoKey);

}

void loop(){

}


int getPianoKey(String command)
{

    b.playSong(command);
    return 1;
}

