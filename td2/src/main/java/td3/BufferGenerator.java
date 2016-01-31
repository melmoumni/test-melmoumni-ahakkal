package td3;

import java.util.List;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.iterable.Iterables;
import net.java.quickcheck.generator.PrimitiveGenerators;

public class BufferGenerator implements Generator<Buffer>{
	Generator<Buffer> buffers = PrimitiveGenerators.nulls();
	Generator<String> str = PrimitiveGenerators.strings();
	public Buffer next() {
		Buffer b = buffers.next();
		b = new Buffer(str.next());
		// TODO Auto-generated method stub
		return b;
	}

}
