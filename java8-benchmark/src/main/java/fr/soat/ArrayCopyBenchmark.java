package fr.soat;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Benchmark the in memory "array copy" operation done between each invokation
 * with fixture {@link PersonnesContainer#reshuflePersonnesArray()} 
 * The goal of this is to determine wether this array copy do add a significant overhead 
 * to the average time we measure in {@link LambdaVsAnonymousBenchmark}  
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations=100, time=10, timeUnit=TimeUnit.MILLISECONDS)
@Measurement(iterations=100, time=10, timeUnit=TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
@Threads(1)
public class ArrayCopyBenchmark {

	@Benchmark
	public void copy_array(PersonnesContainer c, Blackhole blackHole) {
		blackHole.consume(c.personneToSortArray);
	}
	
}
