/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package virtualModules.test.stubs.text;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.CharStreams;

import org.terasology.gestalt.assets.format.AbstractAssetAlterationFileFormat;
import org.terasology.gestalt.assets.format.AssetDataFile;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Immortius
 */
public class TextMetadataFileFormat extends AbstractAssetAlterationFileFormat<TextData> {

    public TextMetadataFileFormat() {
        super("info");
    }

    @Override
    public void apply(AssetDataFile input, TextData assetData) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(input.openStream(), Charsets.UTF_8)) {
            String metadata = Joiner.on("/n").join(CharStreams.readLines(reader));
            assetData.setMetadata(metadata);
        }
    }
}
