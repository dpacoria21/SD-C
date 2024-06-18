import Navbar from '@/components/Navbar/Navbar';

export default function MainLayout({children}: Readonly<{children: React.ReactNode}>) {

    return(
        <main className='min-h-screen bg-slate-300'>
            <Navbar />
            {children}
        </main>
    );
}