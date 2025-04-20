package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Lift extends StaticBody implements StepListener {

        private static final Shape liftShape = new BoxShape(2, 0.2f);

        private Vec2 startPosition;

        private float top, bottom;
        
        private float delta;


        //lift platform
        public Lift(World w) {
            super(w, liftShape);
            startPosition = this.getPosition();
            bottom = startPosition.y-7;
            top = startPosition.y+7;
            delta=0.05f;
            w.addStepListener(this);
        }

    @Override
        public void preStep(StepEvent stepEvent) {
            if (getPosition().y < bottom){
                delta*=-1;
            }
            if (getPosition().y > top){
                delta*=-1;
            }
            this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));
        }

        @Override
        public void postStep(StepEvent stepEvent) {
        }
}
