package seedu.insurancepal.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.insurancepal.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.insurancepal.logic.parser.CliSyntax.PREFIX_REVENUE;

import seedu.insurancepal.commons.core.index.Index;
import seedu.insurancepal.commons.exceptions.IllegalValueException;
import seedu.insurancepal.logic.commands.RevenueCommand;
import seedu.insurancepal.logic.parser.exceptions.ParseException;
import seedu.insurancepal.model.person.Revenue;

public class RevenueCommandParser implements Parser<RevenueCommand> {

    public static final String ILLEGAL_REVENUE_MESSAGE =
            "The revenue is either missing or is in invalid format!";
    /**
     * Parses the given {@code String} of arguments in the context of the RevenueCommand
     * and returns a RevenueCommand object for execution.
     *
     * @param args Command input by the user to be parsed.
     * @return RevenueCommand object for execution based on the command input given.
     * @throws ParseException If the user input does not conform the expected format
     */
    public RevenueCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_REVENUE);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    RevenueCommand.COMMAND_WORD), ive);
        }
        Revenue revenue = argMultimap.getValue(PREFIX_REVENUE).map(s -> {
            try {
                return ParserUtil.parseRevenue(s);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        })
        .orElseThrow(() -> new ParseException(ILLEGAL_REVENUE_MESSAGE));
        return new RevenueCommand(index, revenue);
    }
}
