//
// Source code generated by Celerio, a Jaxio product.
// Documentation: http://www.jaxio.com/documentation/celerio/
// Follow us on twitter: @jaxiosoft
// Need commercial support ? Contact us: info@jaxio.com
// Template pack-angular:web/src/app/entities/entity-line.component.ts.e.vm
//
import {Component, Input} from '@angular/core';
import {Passport} from './passport';

@Component({
	template: `
        {{ passport?.passportNumber }} 	`,
	selector: 'passport-line',
})
export class PassportLineComponent {
    @Input() passport : Passport;
}
