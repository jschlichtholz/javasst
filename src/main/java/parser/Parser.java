package parser;

import scanner.Symbol;
import scanner.SymbolType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * A parser converts a scanner to a tree structure.
 */
public abstract class Parser {

    /**
     * The scanner.
     */
    protected Iterator<Symbol> scanner;

    /**
     * The current symbol.
     */
    protected Symbol symbol;

    /**
     * The current symbols index.
     */
    protected int index = 0;

    /**
     * Create a new parser.
     *
     * @param scanner The scanner.
     */
    public Parser(final Iterator<Symbol> scanner) {
        this.scanner = scanner;
    }

    /**
     * Set current to the next {@link Symbol}.
     */
    protected void next() {
        this.symbol = scanner.next();
        this.index++;
        Logger.getLogger(this.getClass().getName()).info(this.symbol.toString());
    }

    /**
     * Switch to the error state.
     */
    abstract void error(final List<SymbolType> expected);

    /**
     * Start the parsing process (by calling the start node method).
     */
    public abstract void parse();

    /**
     * Allow verifications on the current symbol.
     *
     * @return A {@link Specification} object.
     */
    Specification symbol() {
        return new Specification();
    }

    /**
     *
     */
    protected class Specification {

        /**
         * The expected symbols.
         */
        private final List<SymbolType> expected;

        /**
         * TODO: Documentation.
         */
        public Specification() {
            this.expected = new ArrayList<>();
        }

        /**
         * Add expected symbols to the specification.
         *
         * @param expected The expected symbols.
         * @return A counter object t specify the number of times the symbols have to occur.
         */
        public final Counter is(final SymbolType... expected) {
            this.expected.addAll(Arrays.asList(expected));
            return new Counter(this.expected);
        }

        /**
         * Add expected symbols to the specification.
         *
         * @param expected The expected symbols.
         * @return A counter object t specify the number of times the symbols have to occur.
         */
        public Counter is(final List<SymbolType> expected) {
            return new Counter(expected);
        }
    }

    protected class Counter {

        /**
         * The expected symbols.
         */
        private final List<SymbolType> expected;

        /**
         * TODO: Add docs.
         *
         * @param expected TODO: Add docs.
         */
        public Counter(final List<SymbolType> expected) {
            this.expected = expected;
        }

        /**
         * Make sure the symbol is available exactly once. Throw an error otherwise.
         */
        public void once() {
            if (expected.contains(symbol.getType())) {
                next();
            } else {
                error(expected);
            }
        }

        /**
         * Check whether the symbol is available. Do nothing otherwise.
         */
        public void optional(final Runnable function) {
            if (expected.contains(symbol.getType())) {
                function.run();
            }
        }

        /**
         * TODO: Documentation.
         */
        public void repeat(final Runnable function) {
            while (expected.contains(symbol.getType())) {
                function.run();
            }
        }
    }
}