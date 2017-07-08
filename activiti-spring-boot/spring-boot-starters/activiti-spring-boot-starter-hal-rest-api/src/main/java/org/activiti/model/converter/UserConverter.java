/*
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
 *
 */

package org.activiti.model.converter;

import org.activiti.client.model.User;
import org.activiti.services.model.converter.ListConverter;
import org.activiti.services.model.converter.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**

 */
@Component
public class UserConverter implements ModelConverter<org.activiti.engine.identity.User, User> {

    private final ListConverter listConverter;

    @Autowired
    public UserConverter(ListConverter listConverter) {
        this.listConverter = listConverter;
    }

    @Override
    public User from(org.activiti.engine.identity.User user) {
        User userDTO = new User();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getId());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public List<User> from(List<org.activiti.engine.identity.User> users) {
        return listConverter.from(users, this);
    }

}