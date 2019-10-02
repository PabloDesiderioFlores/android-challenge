package ar.com.mercadolibre.challenge.di;

import javax.inject.Scope;

import kotlin.annotation.Retention;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Scope
@Retention()
public @interface PerActivity {
}
