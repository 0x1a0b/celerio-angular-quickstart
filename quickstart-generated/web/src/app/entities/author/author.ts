//
// Source code generated by Celerio, a Jaxio product.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Follow us on twitter: @jaxiosoft
// Need commercial support ? Contact us: info@jaxio.com
// Template pack-angular:web/src/app/entities/entity.ts.e.vm
//

export class Author {
    // Raw attributes
    id : number;
    civility : string;
    lastName : string;
    firstName : string;
    email : string;
    birthDate : Date;
    birthDateTime : Date;
    // x-to-one
    favoriteAuthor : Author;


    constructor(json? : any) {
        if (json != null) {
            this.id = json.id;
            this.civility = json.civility;
            this.lastName = json.lastName;
            this.firstName = json.firstName;
            this.email = json.email;
            if (json.birthDate != null) {
                this.birthDate = new Date(json.birthDate);
            }
            if (json.birthDateTime != null) {
                this.birthDateTime = new Date(json.birthDateTime);
            }

            if (json.favoriteAuthor != null) {
                this.favoriteAuthor = new Author(json.favoriteAuthor);
            }
        }
    }

    // Utils

    static toArray(jsons : any[]) : Author[] {
        let authors : Author[] = [];
        if (jsons != null) {
            for (let json of jsons) {
                authors.push(new Author(json));
            }
        }
        return authors;
    }
}
