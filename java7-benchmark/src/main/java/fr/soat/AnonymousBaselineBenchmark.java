package fr.soat;

import java.util.Arrays;
import java.util.Comparator;
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

/*
 * Benchmark the java 7 sort solution
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations=100, time=100, timeUnit=TimeUnit.MILLISECONDS)
@Measurement(iterations=100, time=100, timeUnit=TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgsPrepend = { "-server", "-Xmx2g", "-XX:+TieredCompilation" })
@Threads(1)
public class AnonymousBaselineBenchmark {

	@Benchmark
	public void anonymous_class(PersonnesContainer c, Blackhole blackHole) {
		Arrays.sort(c.personneToSortArray, 
				new Comparator<Personne>() {
					public int compare(Personne p1, Personne p2) {
						int nomCompaison = p1.getNom().compareTo(p2.getNom());
						return (nomCompaison != 0) ? nomCompaison : p1.getPrenom().compareTo(p2.getPrenom()) ;
					}
				});
		blackHole.consume(c.personneToSortArray);
	}
	
}
