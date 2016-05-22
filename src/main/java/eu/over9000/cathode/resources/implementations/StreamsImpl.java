package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.FeaturedStreamList;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamTypeOption;
import eu.over9000.cathode.data.parameters.StreamsQuery;
import eu.over9000.cathode.resources.Streams;

public class StreamsImpl extends AbstractEndpoint implements Streams {

	public StreamsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<StreamBox> getStream() {
		return dispatcher.performGet(StreamBox.class, Streams.PATH);
	}

	@Override
	public Result<StreamBox> getStream(final String channelName) {
		return dispatcher.performGet(StreamBox.class, Streams.PATH + "/" + channelName);
	}

	@Override
	public Result<StreamSummary> getSummary() {
		return dispatcher.performGet(StreamSummary.class, Streams.PATH + "/summary");
	}

	@Override
	public Result<FeaturedStreamList> getFeatured(final OffsetPagination pagination) {
		return dispatcher.performGet(FeaturedStreamList.class, Streams.PATH + "/featured", pagination);
	}

	@Override
	public Result<StreamList> getStreams(final StreamsQuery query, final OffsetPagination pagination) {
		return dispatcher.performGet(StreamList.class, Streams.PATH, query, pagination);
	}

	@Override
	public Result<StreamList> getFollowed(final OffsetPagination pagination, final StreamTypeOption streamType) {
		return dispatcher.performGet(StreamList.class, Streams.PATH + "/followed", pagination, streamType);
	}
}