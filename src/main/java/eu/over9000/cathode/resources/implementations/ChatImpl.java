/*
 * Copyright (c) 2016 s1mpl3x <jan[at]over9000.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Badges;
import eu.over9000.cathode.data.ChannelEmoticonList;
import eu.over9000.cathode.data.EmoticonImages;
import eu.over9000.cathode.data.EmoticonList;
import eu.over9000.cathode.data.parameters.Emotesets;
import eu.over9000.cathode.resources.Chat;

public class ChatImpl extends AbstractEndpoint implements Chat {

	public ChatImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<Badges> getBadges(final String channelName) {
		return dispatcher.performGet(Badges.class, Chat.PATH + "/" + channelName + "/badges");
	}

	@Override
	public Result<ChannelEmoticonList> getEmoticons(final String channelName) {
		return dispatcher.performGet(ChannelEmoticonList.class, Chat.PATH + "/" + channelName + "/emoticons");
	}

	@Override
	public Result<EmoticonList> getEmoticons() {
		return dispatcher.performGet(EmoticonList.class, Chat.PATH + "/emoticons");
	}

	@Override
	public Result<EmoticonImages> getEmoticonImages(final Emotesets emotesets) {
		return dispatcher.performGet(EmoticonImages.class, Chat.PATH + "/emoticon_images", emotesets);
	}

	@Override
	public Result<EmoticonImages> getEmoticonImages() {
		return dispatcher.performGet(EmoticonImages.class, Chat.PATH + "/emoticon_images");
	}
}
