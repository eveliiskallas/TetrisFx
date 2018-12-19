package ee.itcollege.tetris;

import ee.itcollege.tetris.parts.Block;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FigureTest {

    private static final double PRECISION = .001;

    @Test
    public void testMove() {
        ee.itcollege.tetris.parts.Figure figure = new ee.itcollege.tetris.parts.Figure();
        Block block = new Block(0, 0);
        figure.add(block);

        assertEquals(0, block.getX(), PRECISION);
        assertEquals(0, block.getY(), PRECISION);

        figure.move(0, 1);
        assertEquals(0, block.getX(), PRECISION);
        assertEquals(Block.SIZE, block.getY(), PRECISION);

        figure.move(2, 0);
        assertEquals(2 * Block.SIZE, block.getX(), PRECISION);
        assertEquals(Block.SIZE, block.getY(), PRECISION);

        figure.move(-3, -5);
        assertEquals(-1 * Block.SIZE, block.getX(), PRECISION);
        assertEquals(-4 * Block.SIZE, block.getY(), PRECISION);
    }

    @Test
    public void testRotate() {
        ee.itcollege.tetris.parts.Figure figure = new ee.itcollege.tetris.parts.Figure();
        Block block = new Block(1, 2);
        figure.add(block);
        figure.add(new Block(0, 0));

        assertEquals( 1 * Block.SIZE, block.getX(), PRECISION);
        assertEquals( 2 * Block.SIZE, block.getY(), PRECISION);

        figure.rotate();
        assertEquals(-2 * Block.SIZE, block.getX(), PRECISION);
        assertEquals( 1 * Block.SIZE, block.getY(), PRECISION);

        figure.rotate();
        assertEquals(-1 * Block.SIZE, block.getX(), PRECISION);
        assertEquals(-2 * Block.SIZE, block.getY(), PRECISION);

        figure.rotate();
        assertEquals( 2 * Block.SIZE, block.getX(), PRECISION);
        assertEquals(-1 * Block.SIZE, block.getY(), PRECISION);

        figure.rotate();
        assertEquals( 1 * Block.SIZE, block.getX(), PRECISION);
        assertEquals( 2 * Block.SIZE, block.getY(), PRECISION);

    }

}
