import { createIngeniero } from '@/actions/ingenieros/createIngeniero';
import { SubmitButton } from '@/components/Form/SubmitButton';
import Table from './ui/Table';
import EngineerForm from './ui/EngineerForm';

export default function page() {

    return (
        <section className='w-full flex flex-col justify-center items-center mt-10'>
            
            <EngineerForm />

            <div className='mt-10'/>

            <Table />

        </section>
    );
}
