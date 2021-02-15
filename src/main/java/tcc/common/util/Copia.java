package tcc.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

public class Copia {
	public Copia() {
		throw new IllegalArgumentException("Nao crie instancias da classe Utility");
	}

	public static void copiaPropriedades(Object s, Object t) {
		BeanUtils.copyProperties(s, t);
	}

	public static void copiaPropriedadesNaoNulas(Object s, Object t) {
		BeanUtils.copyProperties(s,t,obtemNomesDePropriedadadesNulas(s));
	}

	private static String[] obtemNomesDePropriedadadesNulas(Object origem) {
		final BeanWrapper src = new BeanWrapperImpl(origem);

		return Arrays.stream(src.getPropertyDescriptors())
						.map(FeatureDescriptor::getName)
						.filter(nome -> src.getPropertyValue(nome) == null)
						.toArray(String[]::new);
	}
}
