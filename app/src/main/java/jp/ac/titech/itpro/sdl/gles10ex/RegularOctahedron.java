package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class RegularOctahedron implements SimpleRenderer.Obj {

    private final static float[] VERTICES = {
            // surface 1
            -1, 0, 0,
            0, -1, 0,
            0, 0, -1,
            // surface 2
            1, 0, 0,
            0, -1, 0,
            0, 0, -1,
            // surface 3
            -1, 0, 0,
            0, 1, 0,
            0, 0, -1,
            // surface 4
            -1, 0, 0,
            0, -1, 0,
            0, 0, 1,
            // surface 5
            -1, 0, 0,
            0, 1, 0,
            0, 0, 1,
            // surface 6
            1, 0, 0,
            0, -1, 0,
            0, 0, 1,
            // surface 7
            1, 0, 0,
            0, 1, 0,
            0, 0, -1,
            // surface 8
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
    };

    private final FloatBuffer vbuf;

    RegularOctahedron() {
        vbuf = ByteBuffer.allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // surface 1
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // surface 2
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 3, 3);

        // surface 3
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 6, 3);

        // surface 4
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 9, 3);

        // surface 5
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 3);

        // surface 6
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 15, 3);

        // surface 7
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 18, 3);

        // surface 8
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 21, 3);
    }

}
