package org.academiadecodigo.invictus.flappybird.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ObstacleFactory {

public Picture[] createObstacles(){
    Picture[] downObstacles = new Picture[]{new Picture(450, 300, "tinoDown.png"), new Picture(450, 300, "audreyDown")};
    return downObstacles;
}


}
