package com.soebes.tools.izpack.demo;

import com.izforge.izpack.panels.process.AbstractUIProcessHandler;
import com.izforge.izpack.data.PanelAction;
import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.PanelActionConfiguration;
import com.izforge.izpack.api.handler.AbstractUIHandler;

public class IzpackOwnHolloywood
    implements PanelAction
{

    public enum RETURN_CODES
    {
        OK, FAILURE
    }

    private RETURN_CODES returnCode;

    public IzpackOwnHolloywood()
    {
        setReturnCode( RETURN_CODES.FAILURE );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        final IzpackOwnHolloywood callee = new IzpackOwnHolloywood();
        
        callee.run( null, args );

        if ( callee.getReturnCode() != RETURN_CODES.OK )
        {
            System.err.println( "A Problem occurred." );
        }
        
        System.exit( callee.getReturnCode().ordinal() );
    }

    public boolean run( AbstractUIProcessHandler handler, String[] args )
    {
        boolean processingResult = true;
        if ( handler != null )
        {
            handler.logOutput( "Hello, World!", false );
        }
        return processingResult;
    }

    public RETURN_CODES getReturnCode()
    {
        return this.returnCode;
    }

    public void setReturnCode( final RETURN_CODES aReturnCode )
    {
        this.returnCode = aReturnCode;
    }

    @Override
    public void executeAction( final InstallData adata, AbstractUIHandler handler )
    {
        run( null, new String[] { "" } );
    }

    /**
     * Initializes the PanelAction with the given configuration.
     * 
     * @param configuration the configuration. May be <tt>null</tt>
     */
    @Override
    public void initialize( PanelActionConfiguration configuration )
    {
    }
}
