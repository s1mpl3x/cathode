package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class StreamsQuery implements Parameter {

	private enum StreamType {all, playlist, live}

	private String game;
	private List<String> channels;
	private String clientId;
	private StreamType streamType;

	public StreamsQuery(final String game, final List<String> channels, final String clientId, final StreamType streamType) {
		this.game = game;
		this.channels = channels;
		this.clientId = clientId;
		this.streamType = streamType;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();

		if (game != null) {
			result.add(new BasicNameValuePair("game", game));
		}
		if (channels != null && !channels.isEmpty()) {
			result.add(new BasicNameValuePair("channel", String.join(",", channels)));
		}
		if (clientId != null) {
			result.add(new BasicNameValuePair("client_id", clientId));
		}
		if (streamType != null) {
			result.add(new BasicNameValuePair("stream_typ=", streamType.name()));
		}

		return result;
	}

	public String getGame() {
		return game;
	}

	public void setGame(final String game) {
		this.game = game;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(final List<String> channels) {
		this.channels = channels;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(final String clientId) {
		this.clientId = clientId;
	}

	public StreamType getStreamType() {
		return streamType;
	}

	public void setStreamType(final StreamType streamType) {
		this.streamType = streamType;
	}
}