//
// Source code generated by Celerio, a Jaxio product.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Follow us on twitter: @jaxiosoft
// Need commercial support ? Contact us: info@jaxio.com
// Template pack-angular:web/src/app/entities/entity.ts.e.vm
//
import {Passport} from '../passport/passport';
import {Role} from '../role/role';

export class User {
    // Raw attributes
    id : number;
    login : string;
    password : string;
    email : string;
    isEnabled : boolean;
    civility : string;
    countryCode : string;
    firstName : string;
    lastName : string;
    creationDate : Date;
    creationAuthor : string;
    lastModificationDate : Date;
    lastModificationAuthor : string;
    version : number;
    // many-to-many
    roles : Role[];


    constructor(json? : any) {
        if (json != null) {
            this.id = json.id;
            this.login = json.login;
            this.password = json.password;
            this.email = json.email;
            this.isEnabled = json.isEnabled;
            this.civility = json.civility;
            this.countryCode = json.countryCode;
            this.firstName = json.firstName;
            this.lastName = json.lastName;
            if (json.creationDate != null) {
                this.creationDate = new Date(json.creationDate);
            }
            this.creationAuthor = json.creationAuthor;
            if (json.lastModificationDate != null) {
                this.lastModificationDate = new Date(json.lastModificationDate);
            }
            this.lastModificationAuthor = json.lastModificationAuthor;
            this.version = json.version;

            if (json.roles != null) {
                this.roles = Role.toArray(json.roles);
            }
        }
    }

    // Utils

    static toArray(jsons : any[]) : User[] {
        let users : User[] = [];
        if (jsons != null) {
            for (let json of jsons) {
                users.push(new User(json));
            }
        }
        return users;
    }
}
