//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package club.booksmart.identityaccess.domain.model.identity;

import club.booksmart.common.domain.model.ConcurrencySafeEntity;

public class User extends ConcurrencySafeEntity {

    private static final long serialVersionUID = 1L;

    private Person person;
    private TenantId tenantId;


    public void changePersonalContactInformation(ContactInformation aContactInformation) {
       // this.person().changeContactInformation(aContactInformation);
    }

    public void changePersonalName(FullName aPersonalName) {
        //this.person().changeName(aPersonalName);
    }


    public Person person() {
        return this.person;
    }

    public TenantId tenantId() {
        return this.tenantId;
    }

    @Override
    public boolean equals(Object anObject) {
        boolean equalObjects = false;

        if (anObject != null && this.getClass() == anObject.getClass()) {
            User typedObject = (User) anObject;
            equalObjects =
                this.tenantId().equals(typedObject.tenantId());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (45217 * 269)
            + this.tenantId().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "User [tenantId=" + tenantId + ", person=" + person + "]";
    }

    protected User(
            TenantId aTenantId,
            Person aPerson) {

        this();

        this.setPerson(aPerson);
        this.setTenantId(aTenantId);

        // aPerson.internalOnlySetUser(this);

    }

    protected User() {
        super();
    }


    protected void setPerson(Person aPerson) {
        this.assertArgumentNotNull(aPerson, "The person is required.");

        this.person = aPerson;
    }


    protected void setTenantId(TenantId aTenantId) {
        this.assertArgumentNotNull(aTenantId, "The tenantId is required.");

        this.tenantId = aTenantId;
    }

}
